# pubsub

## Step 1: Remove sudo rm google-cloud-sdk.list
cd /etc/apt/sources.list.d
sudo rm google-cloud-sdk.list

## Step 2: Reinstall Google Cloud again
sudo snap remove google-cloud-sdk
sudo apt-get install apt-transport-https ca-certificates gnupg -y
echo "deb [signed-by=/usr/share/keyrings/cloud.google.gpg] https://packages.cloud.google.com/apt cloud-sdk main" | sudo tee -a /etc/apt/sources.list.d/google-cloud-sdk.list
sudo curl https://packages.cloud.google.com/apt/doc/apt-key.gpg | sudo apt-key --keyring /usr/share/keyrings/cloud.google.gpg add -
sudo apt-get update && sudo apt-get install google-cloud-sdk
gcloud init
