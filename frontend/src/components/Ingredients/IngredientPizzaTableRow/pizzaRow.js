import React from "react";

const ingredientRow = (props) => {
    return (
        <tr className={"text-capitalize"}>
            <td>{props.name}</td>
            <td>{props.description}</td>
        </tr>
    )
};

export default ingredientRow;