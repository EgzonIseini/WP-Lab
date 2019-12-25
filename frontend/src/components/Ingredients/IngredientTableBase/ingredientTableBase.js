import React from "react";
import IngredientRow from '../IngredientRow/ingredientRow'
import { Link } from "react-router-dom";

const ingredientTableBase = (props) => {

    const ingredientList = props.ingredients.map((ingredient) => {
        return (
            <IngredientRow key={ingredient.id} name={ingredient.name} amount={ingredient.amount} spicy={ingredient.spicy.toString()} veggie={ingredient.veggie.toString()} id={ingredient.id} onIngredientRemove={props.onIngredientRemove} />
        )
    })


    //If list is empty.
    if(ingredientList.length === 0)
    {
        return (
            <div className="container" style={{ padding: "5rem 1rem 5rem 1rem" }}>
                <h1>There are no ingredients.</h1>
                <div className={"row"}> <Link to={"/ingredients/new"} className="btn btn-success" role="button">Add Ingredient</Link> </div>
            </div>
        )
    }
    else
    {

        return (


            <div className="container flex-" style={{ padding: "5rem 1rem 5rem 1rem" }}>
                <div className="table-responsive">
                    <table className="table">
                        <thead>
                        <tr className="bg-light">
                            <th>Ingredient Name</th>
                            <th>Amount</th>
                            <th>Spicy</th>
                            <th>Veggie</th>
                            <th style={{width: "10%"}}/>
                        </tr>
                        </thead>
                        <tbody>
                        {ingredientList}
                        </tbody>
                    </table>
                </div>
                <div className={"row"}> <Link to={"/ingredients/new"} className="btn btn-success" role="button">Add Ingredient</Link> </div>
            </div>
        );
    }
};

export default ingredientTableBase;