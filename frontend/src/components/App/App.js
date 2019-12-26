import React, { Component } from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Redirect} from 'react-router-dom';

import IngredientService from '../../repository/ingredientsRepository'

import NavigationHeader from '../NavigationHeader/header'
import LandingPage from '../LandingPage/landingPage'
import NavigationFooter from '../NavigationFooter/footer'
import IngredientsList from '../Ingredients/IngredientPage/ingredientLandingPage'
import IngredientAdd from  '../Ingredients/IngredientAdd/addIngredient'
import IngredientEdit from '../Ingredients/IngredientEdit/editIngredient'
import IngredientDetails from '../Ingredients/IngredientDetails/detailsIngredient'
import PizzasList from '../Pizzas/PizzaTable/pizzasTable'

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            ingredients: [],
            pizzas: []
        }
    }

    componentDidMount() {
        this.loadIngredients();
        this.loadPizzas();
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
                        newIngredients.push(newIngredient);
                    } else newIngredients.push(item);

                });

                return {
                    "ingredients": newIngredients
                }
            });
        });
    };

    loadPizzas = () => {
        IngredientService.fetchAllPizzas().then((data) => {
            this.setState({
                pizzas: data.data
            });
        });
    };

    render() {

        const routing = (
            <Router>

                <NavigationHeader />

                <Route path={"/pizzas"} exact render={() => <PizzasList pizzas={this.state.pizzas} onUpdate={this.loadPizzas}/>}/>
                <Route path={"/ingredients/:ingredientId/details"} exact render={() => <IngredientDetails/>} />
                <Route path={"/ingredients/:ingredientId/edit"} exact render={() => <IngredientEdit onIngredientUpdate={this.editIngredient}/>} />
                <Route path={"/ingredients/new"} exact render={() => <IngredientAdd onIngredientAdd={this.addIngredient}/>} />
                <Route path={"/ingredients"} exact render={() => <IngredientsList ingredients={this.state.ingredients} onIngredientRemove={this.removeIngredient} />} />
                <Route path={"/"} exact render={() => <LandingPage/>} />

                <Redirect to={"/"} />

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
