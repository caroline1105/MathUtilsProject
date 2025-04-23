pipeline {
    agent any

    tools {
        jdk 'JDK17' // Change to your Jenkins JDK name
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                bat 'javac -cp .;junit-platform-console-standalone-1.9.3.jar MathUtils.java MathUtilsTest.java'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'java -jar junit-platform-console-standalone-1.9.3.jar -cp . --select-class MathUtilsTest --reports-dir test-results'
            }
            post {
                always {
                    junit 'test-results/*.xml'
                }
            }
        }

        stage('Post Build') {
            steps {
                echo 'Build and tests completed!'
            }
        }
    }

    post {
        success {
            mail to: 'carolinemiranda@student.sfit.ac.in',
                 subject: "✅ Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "All tests passed in your Jenkins pipeline!"
        }
        failure {
            mail to: 'carolinemiranda@student.sfit.ac.in',
                 subject: "❌ Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Please check the console output for errors."
        }
    }
}
