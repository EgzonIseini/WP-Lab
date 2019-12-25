import React from "react";
import {Link} from "react-router-dom";

const ingredientRow = (props) => {

    const deleteElement = () => {
            props.onIngredientRemove(props.id)
    };

    return (
        <tr className={"text-capitalize"}>
            <td>{props.name}</td>
            <td>{props.amount}</td>
            <td>{props.spicy}</td>
            <td>{props.veggie}</td>
            <td className="d-lg-flex justify-content-lg-center align-items-lg-start" style={{ width: "100%" }}>
                <Link to={"/ingredients/" + props.id + "/edit"} className="btn btn-primary" role="button" data-toggle="tooltip" data-bs-tooltip=""
                style={{marginRight: "0.5em"}} title="Edit" href="#"><i className="fa fa-edit"/></Link>
                <button className="btn btn-danger" data-toggle="tooltip"
                        data-bs-tooltip="" type="button" style={{ marginRight: "0.5em" }} title="Remove" onClick={deleteElement}><i
    className="fa fa-trash-o"/></button>
                <Link to={"/ingredients/" + props.id + "/details"} className="btn btn-success" role="button" data-toggle="tooltip" data-bs-tooltip="" title="Details"><i className="fa fa-th-list"/></Link></td>
        </tr>
    )
};

export default ingredientRow;