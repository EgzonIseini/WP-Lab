import React from"react";
import PizzaRow from '../../Ingredients/IngredientPizzaTableRow/pizzaRow'
import {Link} from "react-router-dom";

const pizzasTable = (props) => {

    const pizzas =  props.pizzas.map((pizza, index) => {
        return (
            <PizzaRow key={index} name={pizza.name} description={pizza.description} veggie={pizza.veggie.toString()}/>
        )
    });

    //If list is empty.
    if(pizzas.length === 0)
    {
        return (
            <div className="container" style={{ padding: "5rem 1rem 5rem 1rem" }}>
                <h1>No pizzas with this ingredient.</h1>
            </div>
        )
    }
    else
    {
        return (
            <div className="container" style={{ padding: "5rem 1rem 5rem 1rem" }}>
                <div className="row"><button className="btn btn-success btn" role="button" onClick={props.onUpdate}><i className="fa fa-refresh" /></button></div>
                <div className="table-responsive mt-3">
                    <table className="table">
                        <thead>
                        <tr>
                            <th>Pizza Name</th>
                            <th>Pizza Description</th>
                            <th>Veggie</th>
                        </tr>
                        </thead>
                        <tbody>
                        {pizzas}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
};

export default pizzasTable;