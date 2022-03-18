

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
        url: `http://localhost:8080/user/api/cart`,
        success: function (data) {
            let counter = document.getElementById("cart-counter")
            counter.innerText = data;
        }
    });
}

var totalPrice = 0;
getTotalPrice();

function getTotalPrice() {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/user/api/cart/totalPrice`,
        success: function (data) {
            totalPrice = data.amount * 0.99
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
        url: `http://localhost:8080/user/api/cart`,
        success: function (data) {
            let counter = document.getElementById("cart-counter")
            counter.innerText = data.counter;
            let amount1 = document.getElementById("amount-cart1")
            amount1.innerText = data.amount
            let amount2 = document.getElementById("amount-cart2")
            amount2.innerText = data.amount * 0.01
            let amount3 = document.getElementById("amount-cart3")
            amount3.innerText = data.amount * 0.99
            totalPrice = data.amount * 0.99
        }
    });
}


function deleteCart(id) {
    if (confirm('Are you sure you want to delete') == true) {
        $.ajax({
            type: "DELETE",
            url: `http://localhost:8080/user/api/cart/${id}`,
            success: function (data) {
                let counter = document.getElementById("cart-counter")
                counter.innerText = data.counter
                let amount1 = document.getElementById("amount-cart1")
                amount1.innerText = data.amount
                let amount2 = document.getElementById("amount-cart2")
                amount2.innerText = data.amount * 0.01
                let amount3 = document.getElementById("amount-cart3")
                amount3.innerText = data.amount * 0.99
                totalPrice = data.amount * 0.99
                let row = document.getElementById(`product${id}`)
                row.style.display = "none";
            }
        });
    }
}



function createBill() {
    let userId = $('#hehe').val();
    let date = new Date();
    let note = $('#note').val();
    let statusBill = 1;
    let newBill = {
        user: {
            id:userId
        },
        date: date,
        note: note,
        statusBill: statusBill,
        total: totalPrice
    }
    if (confirm('Are you sure you want to checkout') == true) {
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            data: JSON.stringify(newBill),
            url: `http://localhost:8080/user/api/pay`,
            success: function () {
                alert('Order success')
                window.location.reload();
            }
        });
        event.preventDefault();
    }
}

// count

function getCount() {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/user/api/cart`,
        success: function (data) {
            let counter = document.getElementById("cart-counter")
            counter.innerText = data
        }
    });
}

window.onload = getCount;


// comment

function displayComment(comment) {
    return `<div>
                <p>
                    [<span>${comment.user_id.name}</span>]:
                    <span> ${comment.comment}</span>
                </p>
                <hr>
            </div>`;
}

function getListComment(id) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/user/api/comment/${id}`,
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += displayComment(data[i]);
            }
            document.getElementById("cus-comment").innerHTML = content;
        }
    });
}

function displayFormComment(id) {
    getListComment(id);
    document.getElementById("comment").hidden = false;
    document.getElementById("btn-comment").onclick = function () {
        createComment(id);
    }
}

function createComment(productId) {
    let userId = $('#hehe').val();
    let comment = $('#company').val();
    let newComment = {
        user_id: {
            id: userId,
        },
        comment: comment,
        product: {
            id: productId,
        }
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newComment),
        url: `http://localhost:8080/user/api/add-comment`,
        success: function () {
            getListComment(productId);
            document.getElementById("form-comment").reset();
        }
    });
    event.preventDefault();
}

