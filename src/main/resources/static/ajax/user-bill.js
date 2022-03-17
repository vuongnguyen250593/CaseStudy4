function displayBill(bill) {
    return                  `<tbody>
                            <tr>
                                <td>
                                    <span>${bill.id}</span>
                                </td>
                                <td>
                                    <span>${bill.date}</span>
                                </td>
                                <td>
                                    <span>${bill.price}</span>
                                </td>
                                <td>
                                    <button onclick="viewBillDetail(${bill.id})">View</button>
                                </td>
                            </tr>
                            </tbody>`;
}

function viewBillDetail(id) {

}

function getBill(id) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/products/bill/${id}`,
        success: function (data) {
            let content = `<thead>
                            <tr>
                                <th></th>
                                <th>Date</th>
                                <th>Total Price</th>
                                <th>Action</th>
                            </tr>
                            </thead>`;
            for (let i = 0; i < data.length; i++) {
                content += displayBill(data[i]);
            }
            document.getElementById("table-bill").innerHTML = content;
        }
    });
}