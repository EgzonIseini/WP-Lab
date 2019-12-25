import React, { Component } from 'react';
import './App.css';
import {BrowserRouter as Router, Route} from 'react-router-dom';

import IngredientService from '../../repository/ingredientsRepository'

import NavigationHeader from '../NavigationHeader/header'
import LandingPage from '../LandingPage/landingPage'
import NavigationFooter from '../NavigationFooter/footer'
import IngredientsList from '../Ingredients/IngredientPage/ingredientLandingPage'
import IngredientAdd from  '../Ingredients/IngredientAdd/addIngredient'
import IngredientEdit from '../Ingredients/IngredientEdit/editIngredient'
import IngredientDetails from '../Ingredients/IngredientDetails/detailsIngredient'

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            ingredients: [],
        }
    }

    componentDidMount() {
        this.loadIngredients()
    }

    loadIngredients = () => {
        IngredientService.fetchIngredients().then((data) => {
            this.setState({
                ingredients: data.data
            });
        });
    };

    addIngredient = (ingredient) => {
        IngredientService.pushIngredient(ingredient).then((response) => {

            const newIngredient = response.data;

            this.setState((prevState) => {
                const ingredients = prevState.ingredients.concat(newIngredient);

                return {
                    "ingredients": ingredients
                }
            });
        });
    };

    removeIngredient = (ingredientId) => {
        IngredientService.deleteIngredient(ingredientId).then((response) => {
            this.setState((state) => {
                const ingredients = state.ingredients.filter((i) => {
                    return i.id !== ingredientId;
                });
                return {ingredients}
            });
        });
    };

    editIngredient = (ingredientId, newIngredient) => {

        IngredientService.updateIngredient(ingredientId, newIngredient).then((response) => {

            const newIngredient = response.data;
            this.setState((prevState) => {
                const newIngredients = [];

                prevState.ingredients.forEach((item) => {

                    if(item.id === newIngredient.id) {
                        console.log("Found same ID.");
                        newIngredients.push(newIngredient);
                    } else newIngredients.push(item);

                });

                console.log(newIngredients);

                return {
                    "ingredients": newIngredients
                }
            });
        });
    };

    render() {

        const routing = (
            <Router>

                <NavigationHeader />

                <Route path={"/ingredients/:ingredientId/details"} render={() => <IngredientDetails/>} />
                <Route path={"/ingredients/:ingredientId/edit"} render={() => <IngredientEdit onIngredientUpdate={this.editIngredient}/>} />
                <Route path={"/ingredients/new"} render={() => <IngredientAdd onIngredientAdd={this.addIngredient}/>} />
                <Route path={"/ingredients"} exact render={() => <IngredientsList ingredients={this.state.ingredients} onIngredientRemove={this.removeIngredient} />} />
                <Route path={"/"} exact={true} render={() => <LandingPage/>} />


                <NavigationFooter />
            </Router>
        );

        return (
            <div className={"App"}>

                {routing}

            </div>
        );
    }

}

export default App;
