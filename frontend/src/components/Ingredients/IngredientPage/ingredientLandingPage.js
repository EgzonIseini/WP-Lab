import React from "react";
import IngredientTableBase from '../IngredientTableBase/ingredientTableBase'

const ingredientTable = (props) => {
    
    return (
        <IngredientTableBase ingredients={props.ingredients} onIngredientRemove={props.onIngredientRemove} />
    )

};

export default ingredientTable;