import React, {useEffect, useState} from "react";
import {useHistory, useParams} from "react-router-dom";
import axios from "../../../custom-axios/axios";
import IngredientService from "../../../repository/ingredientsRepository";

import PizzaRow from '../IngredientPizzaTableRow/pizzaRow'
import IngredientRow from "../IngredientRow/ingredientRow";

const ingredientPizzaTable = (props) => {

    const [ingredient, setIngredient] = useState({});
    const [pizzaList, setPizzaList] = useState({})
    const {ingredientId} = useParams();
    const history = useHistory();

    useEffect(() => {
        axios.get("/ingredients/"+ingredientId).then((data)=>{
            setIngredient(data.data);
        }).catch(() => {
            history.push("/ingredients");
        })
    },[])

    useEffect(() => {
        IngredientService.fetchPizzasWithIngredient(ingredientId).then((data) => {
            setPizzaList(data.data)
        });
    },[]);

    const pizzas = Array.from(pizzaList);

    const pizzaRows = pizzas.map((pizza, index) => {
        return (
            <PizzaRow key={index} name={pizza.name} description={pizza.description} veggie={pizza.veggie.toString()}/>
        )
    });

    //If list is empty.
    if(pizzaList.length === 0)
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
            <div className="table-responsive">
                <table className="table">
                    <thead>
                    <tr>
                        <th>Pizza Name</th>
                        <th>Pizza Description</th>
                        <th>Veggie</th>
                    </tr>
                    </thead>
                    <tbody>
                        {pizzaRows}
                    </tbody>
                </table>
            </div>
        );
    }
};

export default ingredientPizzaTable;