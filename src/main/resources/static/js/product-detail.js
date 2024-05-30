function updateProductQuantity(btnType) {
  const quantityStr = document.getElementById("quantity-number").value;
  const quantityStockStr = document.getElementById("quantity-stock").innerText;

  let quantity = parseInt(quantityStr);
  if (btnType === 0) {
    if (quantity > 0)
      quantity--;
    else {
      document.getElementById("toast-error-content").innerText = "Số lượng sản phẩm không thể ít hơn 0";
      showToast("toast-error");
    }
  } else {
    if (quantity < parseInt(quantityStockStr))
      quantity++;
    else {
      document.getElementById("toast-error-content").innerText = "Số lượng sản phẩm không thể nhiều hơn " + quantityStockStr;
      showToast("toast-error");
    }
  }
  document.getElementById("quantity-number").value = quantity;
}

function addToCart () {
  fetch(window.location.origin + "/cart/test")
    .then(response => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json();
    })
    .then(data => {
      console.log(data);
    })
    .catch(error => {
      console.error("There was a problem with the fetch operation:", error);
    });
}
