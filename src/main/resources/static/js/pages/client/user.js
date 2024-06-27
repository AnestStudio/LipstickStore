function confirmDeleteAddress(addressId) {
  document.getElementById("confirm-modal-content").innerText = "Xác nhận xoá địa chỉ này?";
  document.getElementById("btn-confirm-modal").href = window.location.origin + "/user/account/address/delete/" + addressId;
  openModal("confirmModal");
}