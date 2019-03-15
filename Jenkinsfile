node() {

currentBuild.result = "SUCCESS"

    try {

       stage('Checkout'){

          checkout scm
       }

       stage('Run Unit Tests'){

           bat "mvn clean test"
       }

    }
    catch (err) {

        currentBuild.result = "FAILURE"
        throw err
    }

}