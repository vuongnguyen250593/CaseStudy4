

function createLike(id) {
    let userId = 2;
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
        type: "POST",
        data: JSON.stringify(newLike),
        url: `http://localhost:8080/api/like`,
        success: function () {

        }
    });
    event.preventDefault();
}

function deleteLike(id) {
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/api/like/${id}`,
        success: function () {
            let row = document.getElementById(`like${id}`)
            row.style.display = "none";
        }
    });
}