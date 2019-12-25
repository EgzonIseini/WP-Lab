import React from "react";
import {Link} from "react-router-dom";
import {useHistory} from "react-router-dom";

const addIngredient = (props) => {

    const history = useHistory();

    const onFormSubmit = (e) => {
        e.preventDefault()

        let ingredientName = e.target.ingredientName.value,
                ingredientAmount = e.target.ingredientAmount.value;

        if(ingredientName === "" || ingredientAmount === "") {
            return alert("Invalid input! Ingredient name and amount cannot be empty.")
        }

        const newIngredient = {
            "name": ingredientName,
            "spicy": e.target.ingredientSpicy.value,
            "amount": ingredientAmount,
            "veggie": e.target.ingredientVeggie.value
        }
        props.onIngredientAdd(newIngredient)
        history.push("/ingredients")
    }

    return (

        <div className="container" style={{ padding: "5rem 1rem 5rem 1rem" }}>
            <div className="card">
                <div className="card-body">
                    <h4 className="card-title">Add Ingredient</h4>
                    <form onSubmit={onFormSubmit}>
                        <div className="form-group">
                            <div className="form-row">
                                <div className="col">
                                    <div className="input-group m-2">
                                        <div className="input-group-prepend"><span
                                            className="input-group-text">Ingredient Name</span></div>
                                        <input type="text" className="form-control" name="ingredientName"/>
                                    </div>
                                    <div className="input-group m-2">
                                        <div className="input-group-prepend"><span className="input-group-text">Amount</span>
                                        </div>
                                        <input type="number" className="form-control" name="ingredientAmount"/>
                                    </div>
                                    <div className="input-group m-2">
                                        <div className="input-group-prepend"><span className="input-group-text">Spicy</span>
                                        </div>
                                        <select className="form-control" name="ingredientSpicy">
                                            <optgroup label="Please select one: ">
                                                <option value="true">True</option>
                                                <option value="false">False</option>
                                            </optgroup>
                                        </select>
                                    </div>
                                    <div className="input-group m-2">
                                        <div className="input-group-prepend"><span className="input-group-text">Veggie</span>
                                        </div>
                                        <select className="form-control" name="ingredientVeggie">
                                            <optgroup label="Please select one: ">
                                                <option value="true">True</option>
                                                <option value="false">False</option>
                                            </optgroup>
                                        </select>
                                    </div>
                                </div>
                                <div className="col-4 d-xl-flex justify-content-xl-center align-items-xl-center">
                                    <div className="btn-group-vertical btn-group-lg flex-grow-1 justify-content-center"
                                         role="group" style={{ padding: "0em 5em" }}>
                                        <button className="btn btn-success btn-block d-block" type="submit">Save</button>
                                        <Link to={"/ingredients"} className="btn btn-danger btn-block text-light d-block">Discard</Link>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    );
}

export default addIngredient;