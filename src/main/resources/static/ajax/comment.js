
function displayComment(comment) {
    return `<div>
                <p class="form-control">
                    <span>${comment.user_id.name}</span>:
                    <span>${comment.comment}</span>
                </p>
            </div>`;
}

function getListComment(id) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/comment/${id}`,
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += displayComment(data[i]);
            }
            document.getElementById("comment").hidden = false;
            document.getElementById("cus-comment").innerHTML = content;
        }
    });
}

