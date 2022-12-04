<%@page import="com.concerto.springbootmvc.complaintmanagementsystem.entity.Customer" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <style type="text/css">
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                list-style: none;
                font-family: 'Montserrat', sans-serif;
            }

            body {
                background-image: linear-gradient(95.2deg, rgba(173, 252, 234, 1) 26.8%,
                        rgba(192, 229, 246, 1) 64%);
                text-align: center;
            }

            textarea {
                resize: none;
            }

            .wrapper {
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                display: flex;
            }

            .registration_form {
                border-radius: 5px;
                width: 470px;
                background: white;
                padding: 25px;
            }

            .registration_form .title {
                color: white;
                background: rgb(13, 98, 215);
                letter-spacing: 2px;
                font-weight: 700;
                text-align: center;
                font-size: 25px;
                text-transform: uppercase;
                margin-top: -25px;
                margin-left: -25px;
                margin-right: -25px;
            }

            .form_wrap {
                margin-top: 35px;
            }

            .form_wrap .input_wrap {
                margin-bottom: 15px;
            }

            .form_wrap .input_wrap:last-child {
                margin-bottom: 0;
            }

            .form_wrap .input_wrap label {
                margin-bottom: 3px;
                color: #1a1a1f;
                display: block;
            }

            .form_wrap input[type="text"] {
                width: 100%;
                padding: 10px;
                outline: none;
                border-radius: 3px;
                border: 1.3px solid #9597a6;
            }

            .form_wrap input[type="text"]:focus {
                border-color: #063abd;
            }

            .form_wrap textarea:focus {
                border-color: #063abd;
            }

            .form_wrap textarea {
                width: 100%;
                padding: 10px;
                outline: none;
                border-radius: 3px;
                border: 1.3px solid #9597a6;
            }

            /* Submit Button */
            .form_wrap .submit_btn {
                font-size: 17px;
                border-radius: 3px;
                text-transform: uppercase;
                letter-spacing: 2px;
                cursor: pointer;
                width: 100%;
                background: #0d6ad7;
                padding: 10px;
                border: 0;
                color: white;
            }

            /* Button Hover effect */
            .form_wrap .submit_btn:hover {
                background: #051c94;
            }

            #the-count {
                float: right;
                padding: 0.1rem 0 0 0;
                font-size: 0.875rem;
            }
        </style>
    </head>

    <body>
        <% Customer customer=(Customer) request.getAttribute("customer"); %>


                <!-- Form -->
                <form action="/admin/updateComplaint" method="post" id="updateForm">
                    <div class="form_wrap">

                        <div class="input_wrap">
                            <label for="complaintId">User Name</label> <input type="text" id="User Name"
                                name="User Name" value=<%= customer.getCustomerName()%>>
                        </div>

                        <div class="input_wrap">
                            <label for="contactNumber">Contact Number</label>
                            <textarea id="contactNumber" name="contactNumber">
                                <%=customer.getContact()%>
                            </textarea>
                        </div>

                        <div class="input_wrap">
                            <input type="submit" value="Save Changes" class="submit_btn">
                        </div>

                    </div>
                    <br>
                    <button>
                        <a href="/customer/dashboard">main menu</a>
                    </button>
                </form>
                </div>
                </div>

                <script type="text/javascript">
                    $('#updateForm').on('submit', function (event) {
                        event.preventDefault();
                        console.log($('#complaintId').val());

                        let formData = {
                            "customerId": $('#complaintId').val(),
                            "customerName": $('#customerName').val(),
                            "contact": $('#contact').val(),
                            "email": $('#email').val(),
                        }

                        $.ajax({
                            type: "post",
                            contentType: 'application/json; charset=utf-8',
                            dataType: 'json',
                            url: 'updateComplaint',
                            data: JSON.stringify(formData),
                            success: function (result) {
                                console.log(result)

                                $('#success-alert').show();
                                setTimeout(function () {
                                    $("#success-alert").hide();
                                }, 9000);
                            },
                            error: function (xhr, status, error) {
                                console.log(error)

                            },
                        })
                    })

                    $('textarea')
                        .keyup(
                            function () {

                                var characterCount = $(this).val().length,
                                    current = $('#current'),
                                    maximum = $('#maximum'),
                                    theCount = $('#the-count');
                                current.text(characterCount);
                            });
                </script>
    </body>

    </html>