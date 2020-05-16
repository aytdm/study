<script context='module'>
  export function preload({ params, query }) {
    return this.fetch(`index.json`)
    .then(r => r.json())
    .then(posts => {
      return { posts };
    });
  }
</script>

<script>
  export let posts;
</script>

<style lang='scss'>
  .post {
    margin: 1em 0;

    &__title {
      margin-block-start: 0;
      margin-block-end: 0.5em;

      &--link {
        text-decoration: none;
      }

      &:hover {
        text-decoration: underline;
      }
    }

    &__content {
      color: $color-dark-gray;
      font-size: 0.8em;
      text-align: left;
      text-transform: uppercase;
      margin-right: 16px;
    }
  }
</style>

<svelte:head>
  <title>aytdm.com</title>
</svelte:head>

<div class='container'>
  {#each posts as post, index}
    {#if index}
      <hr />
    {/if}
    <div class='post'>
      <h3 class='post__title'>
        <a class='post__title--link' rel='prefetch' href='{post.slug}'>{post.title}</a>
      </h3>
      <div class='post__content'>
        {post.printDate}
        <p>
          {post.excerpt}
        </p>
      </div>
    </div>
  {/each}
</div>
