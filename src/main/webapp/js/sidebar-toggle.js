/**
 * 
 */
document.addEventListener("DOMContentLoaded", function () {
  const toggleBtn = document.getElementById('toggleSidebar');
  const sidebar = document.getElementById('sidebar');
  const content = document.getElementById('content');

  if (toggleBtn && sidebar && content) {
    toggleBtn.addEventListener('click', function () {
      sidebar.classList.toggle('sidebar-collapsed');
      content.classList.toggle('content-expanded');
    });
  }
});
