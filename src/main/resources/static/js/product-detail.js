function updateProductQuantity(btnType) {
  const quantityStr = document.getElementById("quantity-number").value;
  const quantityStockStr = document.getElementById("quantity-stock").innerText;

  let quantity = parseInt(quantityStr);
  let quantityStock = parseInt(quantityStockStr);
  if (btnType === 0) {
    if (quantity > 1) {
      quantity--;
    } else {
      document.getElementById("toast-error-content").innerText = "Số lượng sản phẩm không thể ít hơn 1";
      showToast("toast-error");
    }
  } else {
    if (quantity < quantityStock) {
      quantity++;
    } else {
      document.getElementById("toast-error-content").innerText = "Số lượng sản phẩm không thể nhiều hơn " + quantityStock;
      showToast("toast-error");
    }
  }
  document.getElementById("quantity-number").value = quantity;
}

function addToCart(productId) {
  const quantityStr = document.getElementById("quantity-number").value;
  const quantityStockStr = document.getElementById("quantity-stock").innerText;

  const apiUrl = window.location.origin + '/api/cart/add?productId=' + productId + '&quantity=' + quantityStr;
  fetch(apiUrl)
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok ' + response.statusText);
      }
      return response.json();
    })
    .then(data => {
      document.getElementById("quantity-stock").innerText = "" + (parseInt(quantityStockStr) - parseInt(quantityStr));
      document.getElementById("quantity-item-in-cart").innerText = data.quantityItemInCart;
      document.getElementById("toast-success-content").innerText = "Thêm sản phẩm vào giỏ hàng thành công.";
      showToast("toast-success");
      console.log(data);
    })
    .catch(error => {
      handlerCommonError(error);
    });
}
