function orderProcess(shippingAddressId) {
  const note = document.getElementById("order-note").value;
  window.location.href = window.location.origin + "/checkout/process?userShippingAddressId=" + shippingAddressId + "&orderNote=" + note;
}
