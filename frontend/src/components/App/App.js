import React, { Component } from 'react';
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom';
import NavigationHeader from '../NavigationHeader/header'
import LandingPage from '../LandingPage/landingPage'
import NavigationFooter from '../NavigationFooter/footer'
import './App.css';

import IngredientsList from '../Ingredients/IngredientPage/ingredientLandingPage'

class App extends Component {

    render() {

        const routing = (
            <Router>

                <NavigationHeader />

                <Route path={"/ingredients"} exact render={() => <IngredientsList />} />
                <Route path={"/"} exact={true} render={() => <LandingPage/>}/>


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
