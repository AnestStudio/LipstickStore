function addToCart(id) {
  const quantity = document.getElementById("quantity").value;

  const apiUrl = "http://localhost:8080/cart/" + id + "/" + quantity;
  fetch(apiUrl)
    .then(response => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json();
    })
    .then(data => {
      document.getElementById("quantityItemInCart").innerText = data;
      showToast("liveToast");
    })
    .catch(error => {
      console.error("Error:", error);
    });
}