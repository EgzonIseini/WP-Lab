import React from "react";
import IngredientRow from '../IngredientRow/ingredientRow'

const ingredientTableBase = (props) => {

    return (
        <div className="container" style={{ padding: "5rem 1rem 5rem 1rem" }}>
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
                        <IngredientRow id={"1"} name={"Tomato Sauce"} amount={"200g"} spicy={"False"} veggie={"True"}/>
                        <IngredientRow id={"2"} name={"Cheese"} amount={"150g"} spicy={"False"} veggie={"False"}/>
                        <IngredientRow id={"3"} name={"Mushrooms"} amount={"10"} spicy={"False"} veggie={"True"}/>
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default ingredientTableBase;