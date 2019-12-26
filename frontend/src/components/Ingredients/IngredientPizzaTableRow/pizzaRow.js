import React from "react";

const ingredientRow = (props) => {
    return (
        <tr className={"text-capitalize"}>
            <td>{props.name}</td>
            <td>{props.description}</td>
            <td>{props.veggie}</td>
        </tr>
    )
};

export default ingredientRow;