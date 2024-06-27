function getOrdersByStatus(statusId) {
  let currentUrl = window.location.href;
  currentUrl = updateQueryStringParameter(currentUrl, 'statusIds', statusId);
  window.location.href = currentUrl;
}