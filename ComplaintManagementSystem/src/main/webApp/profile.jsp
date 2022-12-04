<%@page import="com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>


        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>

            <link rel="stylesheet" href="css/profile.css">
            <link rel="preconnect" href="https://fonts.gstatic.com">
            <link href="https://www.pngitem.com/middle/ixJxJh_default-profile-picture-circle-hd-png-download/"
                rel="stylesheet">
        </head>

        <body>
            <% Customer customer=(Customer) request.getAttribute("customer"); Integer noOfComplaints=(Integer)
                request.getAttribute("noOfComplaints"); %>

                <div class="container">
                    <div class="user-image">
                        <img src="https://www.pngitem.com/pimgs/m/22-223968_default-profile-picture-circle-hd-png-download.png"
                            alt="this image contains user-image"><br><br>
                        <h3 class="name">
                            <%= customer.getCustomerName() %>
                        </h3>
                    </div>

                    <div class="content">

                        <p class="username">
                            <%= customer.getCustomerUsername() %>
                        </p>
                        <br>
                        <p>
                            <img src="https://mailmeteor.com/logos/assets/PNG/Gmail_Logo_256px.png" alt="" class="logo">
                            &nbsp;<i>
                                <%= customer.getEmail() %>
                            </i>
                        </p>
                        <br>
                        <p><img src="https://uxwing.com/wp-content/themes/uxwing/download/communication-chat-call/contact-icon.png"
                                class="logo">
                            <%= customer.getContact() %>
                        </p>
                        <br>
                        <p> <b>
                                Total Complaints</b>
                            <%= noOfComplaints %>
                        </p>
                        <br>
                        <h3>
                            Date of birth <%= customer.getDateOfBirth() %>
                        </h3>
                        <br><br><br><br><br>
                        <a class="effect effect-4" href="/editprofile?customerId=${customerId}">
                            Edit Profile
                        </a>
                    </div>
                </div>

                <!-- This is link of adding small images
		which are used in the link section -->
                <script src="https://kit.fontawesome.com/704ff50790.js" crossorigin="anonymous">
                </script>

        </body>

        </html>