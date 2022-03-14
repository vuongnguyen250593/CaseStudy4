function getProductDetail(product) {
    return `
                            <tbody>
                            <tr>
                                <td class="cart_product_img">
                                    <a href="#"><img src="${product.image}" alt="Product"></a>
                                </td>
                                <td class="cart_product_desc">
                                    <h5>${product.name}</h5>
                                </td>
                                <td class="price">
                                    <span>${product.price}</span>
                                </td>
                                <td class="qty">
                                    <div class="qty-btn d-flex">
                                        <div class="quantity">
                                            <span class="qty-minus"
                                                  onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i
                                                    class="fa fa-minus" aria-hidden="true"></i></span>
                                            <input type="number" class="qty-text" id="qty" step="1" min="1" max="300"
                                                   name="quantity" value="1">
                                            <span class="qty-plus"
                                                  onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i
                                                    class="fa fa-plus" aria-hidden="true"></i></span>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
    `;
}

function addToCart() {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/products`,
        success: function (data) {
            let content = `
                            <thead>
                            <tr>
                                <th></th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                            </tr>
                            </thead>        
            `;
            for (let i = 0; i < data.length; i++) {
                content += getProductDetail(data[i]);
            }
            document.getElementById("cart-product-detail").innerHTML = content;
        }
    });
}