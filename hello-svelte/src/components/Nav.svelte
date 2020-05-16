<script>
  export let segment;
</script>

<style lang='scss'>
  .nav {
    padding: 1em;

    &__item {
      text-decoration: none;
      font-size: 1.2em;
      font-weight: bold;

      &__icon {
        height: 32px;
        vertical-align: middle;
      }
    }
  }
</style>

<nav class='nav'>
  <a class='nav__item' aria-current='{segment === undefined ? "page" : undefined}' href='.'>
    <img alt='logo' class='nav__item__icon' src='icons/logo.png'>
    <span>aytdm.com</span>
  </a>
</nav>
