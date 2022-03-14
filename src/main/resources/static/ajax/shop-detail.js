function addToCart(id) {
    event.preventDefault();
    let newCart = {
        "id": id,
        "name": name,
        "quantity": 1,
        "price": price
    };
    console.log(id)

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


function viewCart() {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/bill`,
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

function getProductDetail(data) {
    return `
                            <tbody>
                            <tr>
                                <td class="cart_product_img">
                                    <a href="#"><img src="${data.product.image}" alt="Product"></a>
                                </td>
                                <td class="cart_product_desc">
                                    <h5>${data.product.name}</h5>
                                </td>
                                <td class="price">
                                    <span>${data.totalMoney}</span>
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



function viewProductDetail(id) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/products/${id}`,
        success: function (data) {
            let content = `
            <div class="row">
                    <div class="col-12 col-lg-7">
                        <div class="single_product_thumb">
                            <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li class="active" data-target="#product_details_slider" data-slide-to="0" style="background-image: url(https://ict-imgs.vgcloud.vn/2021/09/10/09/lo-gia-iphone-13-re-nhat-bao-nhieu.jpg);">
                                    </li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <a class="gallery_img" href="${data.image}">
                                            <img class="d-block w-100" src="${data.image}" alt="First slide">
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-lg-5">
                        <div class="single_product_desc">
                            <!-- Product Meta Data -->
                            <div class="product-meta-data">
                                <div class="line"></div>
                                <p class="product-price">${data.price}</p>
                                <a href="shop-details.html">
                                    <h6>${data.name}</h6>
                                </a>
                                <!-- Ratings & Review -->
                                <div class="ratings-review mb-15 d-flex align-items-center justify-content-between">
                                        <div class="cart">
                                            <a href="user-favourite.html" data-toggle="tooltip" data-placement="left" title="Follow Product"><img
                                                    src="img/core-img/tim.png" alt=""></a>
                                        </div>
                                        <div class="cart">
                                            <a href="#" data-toggle="tooltip" data-placement="left" title="Comment"><img
                                                    src="img/core-img/cmt.png" alt=""></a>
                                        </div>
                                </div>
                                <!-- Avaiable -->
                                <p class="avaibility"><i class="fa fa-circle"></i> Tình trạng: Còn ${data.quantity} sản phẩm</p>
                            </div>

                            <div class="short_overview my-5">
                                <p>${data.description}</p>
                            </div>

                            <!-- Add to Cart Form -->
<!--                            <form class="cart clearfix" method="post" action="shop-cart.html">-->
                                <a href="#" class="btn amado-btn" onclick="addToCart(${data.id}, '${data.name}', ${data.price})">Add to cart</a>
<!--                            </form>-->
                        </div>
                    </div>
                </div>
            `;
            document.getElementById("view-product-detail").innerHTML = content;
        }
    });
}

