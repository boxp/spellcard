# {{name}}

FIXME

## Prerequisites

- Leiningen(https://leiningen.org/)

### Optionals(For GKE Cluster)

- Google Cloud SDK(https://cloud.google.com/sdk/)
- Your GCP Account
- Your CircleCI Account

## Usage(Local Environment)

```sh
lein run
```

## Deploy to GKE Cluster

1. Add Integration with CircleCI to your GitHub repository.
2. Add your Google Application Credentials as `$ACCT_AUTH`.
3. Just `git push` commits.

## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
