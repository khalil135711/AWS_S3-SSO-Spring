# 🩺 Doctor-Patient Video Call Web Application

**See this video to understand**: [https://github.com/khalil135711/AWS_S3-SSO-Spring/Spring Boot And WebRTC-2.mp4](https://github.com/khalil135711/AWS_S3-SSO-Spring/blob/main/Spring%20Boot%20And%20WebRTC-2.mp4)

This web application facilitates real-time video calls between doctors and patients. Built using Spring Boot, WebRTC, and Bootstrap, it allows doctors and patients to connect via video calls and generate personalized *medical reports* in PDF format directly from the application.

## 🚀 Features

Real-Time Video Calls: Connect doctors and patients for face-to-face consultations using WebRTC.
Multi-Room Support: Create and join multiple video call rooms for different consultations.
PDF Report Generation: Generate customized medical reports with patient information, including name, birthdate, medicament, and more.
Image Embedding in PDFs: Add an image (e.g., a clinic logoin this case "Rot kreuz") to the PDF report.
Modern UI: Responsive and user-friendly interface built with Bootstrap.

# 🛠️ Technologies Used

Backend: Spring Boot
Frontend: HTML, CSS (Bootstrap), JavaScript
Real-Time Communication: WebRTC
PDF Generation: jsPDF library
WebSocket: For handling real-time signaling between clients
# 📋 Prerequisites

To run this project, ensure you have the following installed:

Java 8+
Maven
Node.js (for managing frontend dependencies)

# ⚙️ Installation & Setup

- Clone the Repository:
--> git clone https://github.com/khalil135711/AWS_S3-SSO-Spring/
--> cd AWS_S3-SSO-Spring

-Backend Setup:
  Open the project in your favorite IDE.
  Run mvn clean install to build the project.
  Start the Spring Boot application:
  --> mvn spring-boot:run
The application will be available at http://localhost:8080. **(in next project i will try to deploy it on **AWS** )**
## 🚀 How to Use

**-Joining a Room:**
Open the application in your browser (http://localhost:8080).

Enter a room ID (this can be any unique identifier try as example your ID CARD, versicherungsNummer…) and click "Join Room".
Share the room ID with the other participant (doctor or patient) so they can join the same room.
Once both parties are in the room, the video call will start automatically.
**-Control Video and Audio:**
Use the "Mute" button to toggle the microphone on/off.
Use the "Turn Off Camera" button to toggle the camera on/off.
**-Generate PDF:**
Click the "Generate PDF" button to open a modal where you can input the patient's name, birthdate, and medicament.
After filling in the details, click "Generate PDF" to download a personalized medical report.
**🖼️ Adding an Image to the PDF**

To include an image (e.g., a clinic logo, ) in the generated PDF:

Update the image URL in the generatePDF() function inside your HTML file:
--->  const imageUrl = 'https://your-image-url-here.com/logo.png'; // image link for your logo .

## 🤝 Contributing

• **Contributions are welcome!** If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.

