<script context="module">
  export async function preload({ params, query }) {
    // the `slug` parameter is available because
    // this file is called [slug].html
    const res = await this.fetch(`${params.slug}.json`);
    const data = await res.json();

    if (res.status === 200) {
      return { post: data };
    } else {
      this.error(res.status, data.message);
    }
  }
</script>

<script>
  export let post
</script>

<style lang='scss'>
  .header {
    margin-bottom: 32px;

    &__title {
      margin-block-end: 0em;
    }

    &__date {
      margin-block-start: 0em;
      color: $color-dark-gray;
      text-transform: uppercase;
    }
  }
</style>

<svelte:head>
  <title>{post.title}</title>
</svelte:head>

<header class='header'>
  <h2 class='header__title'>{post.title}</h2>
  <p class='header__date'>{post.printDate} ~ {post.printReadingTime}</p>
</header>
<div class="container">
  <article class="content">
    {@html post.html}
  </article>
</div>
