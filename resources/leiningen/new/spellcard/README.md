# {{name}}

FIXME

## Prerequisites

- Leiningen(https://leiningen.org/)

### Optionals(For GKE Cluster)

- Google Cloud SDK(https://cloud.google.com/sdk/)
- Your GCP Account

## Usage(Local Environment)

```sh
lein run
```

## Deploy to GKE Cluster

1. Add Integration with [Google Cloud Container Builder](https://cloud.google.com/container-builder/docs/running-builds/automate-builds) to your GitHub repository.
2. Add Kubernetes Engine IAM role.(quoted from [Official Document](https://cloud.google.com/container-builder/docs/configuring-builds/build-test-deploy-artifacts#deploying_artifacts))
	1. visit [IAM menu](https://console.cloud.google.com/iam-admin/iam/project?_ga=2.85671577.-1255311422.1517556095).
	2. From the list of service accounts, click the Roles drop-down menu beside the Container Builder [YOUR-PROJECT-ID]@cloudbuild.gserviceaccount.com service account.
	3. Click *Kubernetes Engine*, then click *Kubernetes Engine Admin*.
	4. Click Save.
3. Just `git push` commits.

## License

Copyright © 2018 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
