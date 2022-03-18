function displayUser(user) {
    return `<tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
            </tr>`
}

function findUser() {
    let username = document.getElementById("email").value;
    $.ajax({
        type: "POST",
        url: `http://localhost:8080/username?username=${username}`,
        success: function (data) {
            let content = `<tr>
                                <th>id</th>
                                <th>name</th>
                                <th>email</th>
                                <th>phone</th>
                            </tr>`;
            for (let i = 0; i < data.length; i++) {
                content += displayUser(data[i]);
            }
            document.getElementById("userlist").innerHTML = content;
        }
    });
}

function getUser() {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/user-information`,
        success: function (data) {
            document.getElementById("hehe").value = data.id;
        }
    });
}

getUser();