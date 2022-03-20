


function createLikeDefault(id) {
    let userId = $('#hehe').val();
    let productId = id;
    let newLike = {
        user: {
            id: userId
        },
        product: {
            id: productId
        },
        statusLike: {
            s_id: 2
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newLike),
        url: `http://localhost:8080/user/api/like/${productId}/${userId}`,
        success: function (data) {
            console.log(data)
            let content = "";
            if (data.statusLike.s_id === 2) {
                content += `
                                <div class="cart">
                                    <a href="#" data-toggle="tooltip" data-placement="left"
                                       title="follow Product" onclick="createLike(${id})">
                                      <img src="/img/core-img/tim.png" alt="" >
                                    </a>
                                </div>
                `;
            } else if (data.statusLike.s_id === 1) {
                content += `
                                <div class="cart">
                                    <a href="#" data-toggle="tooltip" data-placement="left"
                                       title="Unfollow Product" onclick="editLike(${id})">
                                      <img src="/img/core-img/tim-tim.png" alt="" >
                                    </a>
                                </div>
                `;
            }
            document.getElementById("my-like").innerHTML = content;
        }
    });
}

function createLike(id) {
    let userId = $('#hehe').val();
    let productId = id;
    let newLike = {
        user: {
            id: userId
        },
        product: {
            id: productId
        },
        statusLike: {
            s_id: 1
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(newLike),
        url: `http://localhost:8080/user/api/like/${productId}/${userId}`,
        success: function () {
            createLikeDefault(productId)
        }
    });
    event.preventDefault();
}

function editLike(id) {
    let userId = $('#hehe').val();
    let productId = id;
    let newLike = {
        user: {
            id: userId
        },
        product: {
            id: productId
        },
        statusLike: {
            s_id: 2
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(newLike),
        url: `http://localhost:8080/user/api/like/${productId}/${userId}`,
        success: function () {
            createLikeDefault(productId)
        }
    });
    event.preventDefault();
}

function deleteLike(id) {
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/user/api/like/${id}`,
        success: function () {
            let row = document.getElementById(`like${id}`)
            row.style.display = "none";
        }
    });
}

function favourite() {
    let userId = $('#hehe').val();
    window.location.replace(`http://localhost:8080/user/favourite/${userId}`)
}


