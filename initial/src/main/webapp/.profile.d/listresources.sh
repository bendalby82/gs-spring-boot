#List contents of /home/vcap on start up
#Ref: https://discuss.pivotal.io/hc/en-us/articles/221429687-How-to-initialize-the-application-container-environment-with-profile-d-script
#Stored at: https://gist.github.com/bendalby82/bda1bfd6744ae6dfe68ee168a8863287
#Check the contents of cf logs <APP NAME> to see output.
echo "**************************************************"
echo "START: listresources.sh running in .profile.d"
echo "Running 'find /home/vcap'"
echo "**************************************************"
find /home/vcap
echo "**************************************************"
echo "STOP:  listresources.sh completed"
echo "**************************************************"
