/*
 * USER UPDATE PROFILE -------------------------------------------------------------------------------------------------
 */

function togglePasswordVisibility(id) {
  const element = document.getElementById(id);
  if (element.type === "password") {
    element.type = "text";
  } else {
    element.type = "password";
  }
}


/*
 * USER ADDRESS --------------------------------------------------------------------------------------------------------
 */

function confirmDeleteAddress(addressId) {
  document.getElementById("confirm-modal-content").innerText = "Xác nhận xoá địa chỉ này?";
  document.getElementById("btn-confirm-modal").href = window.location.origin + "/user/account/address/delete/" + addressId;
  openModal("confirmModal");
}


/*
 * USER ORDERS ---------------------------------------------------------------------------------------------------------
 */

orderStatusCount();

function getOrdersByStatus(statusId) {
  window.location.href = updateQueryStringParameter(window.location.origin + "/user/orders", 'statusIds', statusId);
}

function renderOrderStatus(orderStatusCount) {
  let totalOrders = 0;
  orderStatusCount.forEach(item => {
    const statusId = item[0];
    const count = item[1];
    totalOrders += parseInt(count);
    const badge = document.getElementById(`status-${statusId}`);
    if (badge) {
      badge.textContent = count;
    }
  });
  document.getElementById("status-all").textContent = totalOrders;
}

function fetchOrderStatusCount() {
  const EXPIRATION_TIME = 15 * 60 * 1000; // 15 min
  fetch("/api/user/orders/status-count")
    .then(response => response.json())
    .then(data => {
      renderOrderStatus(data);
      const expirationTime = new Date().getTime() + EXPIRATION_TIME;
      localStorage.setItem("ORDER_STATUS_COUNT", JSON.stringify({ data, expirationTime }));
    })
    .catch(error => handlerCommonError(error));
}

function orderStatusCount() {
  const orderStatusCount = localStorage.getItem("ORDER_STATUS_COUNT");
  if (orderStatusCount) {
    const parsedData = JSON.parse(orderStatusCount);
    const currentTime = new Date().getTime();

    if (currentTime < parsedData.expirationTime) {
      renderOrderStatus(parsedData.data);
    } else {
      localStorage.removeItem("ORDER_STATUS_COUNT");
      // Fetch new data from API
      fetchOrderStatusCount();
    }
  } else {
    // Fetch data from API if not available in localStorage
    fetchOrderStatusCount();
  }
}
