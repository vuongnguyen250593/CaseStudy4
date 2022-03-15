function addToCart(id, image, name, price) {
    let newCart = {
        "id": id,
        "image": image,
        "name": name,
        "quantity": 1,
        "price": price
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newCart),
        url: `http://localhost:8080/api/cart`,
        success: function (data) {
            let counter = document.getElementById("cart-counter")
            counter.innerText = data;
        }
    });
}

function updateCart(obj, productId) {
    let updateCart = {
        "id": productId,
        "image": "",
        "name": "",
        "quantity": obj.value,
        "price": 0
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(updateCart),
        url: `http://localhost:8080/api/cart`,
        success: function (data) {
            let counter = document.getElementById("cart-counter")
            counter.innerText = data.counter;
            let amount1 = document.getElementById("amount-cart1")
            amount1.innerText = data.amount
            let amount2 = document.getElementById("amount-cart2")
            amount2.innerText = data.amount * 0.01
            let amount3 = document.getElementById("amount-cart3")
            amount3.innerText = data.amount * 0.99
        }
    });
}

function deleteCart(id) {
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/api/cart/${id}`,
        success: function (data) {
            let counter = document.getElementById("cart-counter")
            counter.innerText = data.counter
            let amount1 = document.getElementById("amount-cart1")
            amount1.innerText = data.amount
            let amount2 = document.getElementById("amount-cart2")
            amount2.innerText = data.amount * 0.01
            let amount3 = document.getElementById("amount-cart3")
            amount3.innerText = data.amount * 0.99
            let row = document.getElementById(`product${id}`)
            row.style.display = "none";
        }
    });
}

function getCount() {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/cart`,
        success: function (data) {
            let counter = document.getElementById("cart-counter")
            counter.innerText = data
        }
    });
}

window.onload = getCount;