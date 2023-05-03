# **The Project "Prestashop"**

# Description:
The site http://prestashop.qatestlab.com.ua/ - is an online store for women's clothing, which has a category that
called _WOMEN_. he WOMEN category is divided into sections such as: _Tops,Dresses, Jackets, Shoes, Bags, Suits_.
On the Products page, for easy product search, you can select a filter in which you can select "Категории", "Size", 
"Color", "Properties", "Compositions", "Styles", "Наличие", "Производитель", "Состояние", "Вес". On the Products page 
you can sort, display 12, 24, 60 products per page The product can be viewed by "Quick review", "Добавить в корзину", 
"View", "Добавить в список желаний", "Add to Compare".
The range of goods is constantly updated on the site, new items appear, there are discounts, there is a delivery of 
goods.

# Checklist:
**AUTHENTICATION**
1. The field "Email address" is with valid data.
2. The field "Email address" is with empty data.
3. The field "Email address" is with invalid data.
4. The field "YOUR PERSONAL INFORMATION" is with empty fields.
5. The fields last name, first name, password in "YOUR PERSONAL INFORMATION0" are inputted with valid data.

**Login**
1. Sign in is with valid data: Username and Password.
2. Sign in is with empty data: Username, Password. 
3. Sign in is with empty data: Username, valid data: Password. 
4. Sign in is with empty data: Password, valid data: Username.

**Logout**
1. Click on the button "Sign out".
2. Click on the button "Sign out" and check personal area.

**MY ACCOUNT Page (Personal Page)**
1. Check categories are displayed: ADD MY FIRST ADDRESS, ORDER HISTORY AND DETAILS, MY CREDIT SLIPS, MY ADDRESSES, MY PERSONAL INFORMATION, МОИ СПИСКИ ПОКУПОК.
2. Check the button "Home" is redirected on Main page.
3. Check the button Name/Surname is redirected on MY ACCOUNT Page.

**Main page** / **Products page**
1. Displayed 3 categories: Women, Dresses, T-Shirts.
2. Default - the tab "Popular" products.
3. The tab "BEST SELLERS" is clickable and displayed products.

**Search**
1. The empty search is validate message.
2. Valid data.
3. No search results - validation message.

**Cart Page**
1. Check content (name, price), name is link to product page, remove button is clickable.
2. Check if button is clickable and directs to checkout page
3. Check if Qty = 0 and clicks Proceed to checkout, redirects to next step 
4. Check if click on the delete, redirects to next step

**Checkout (Sign in)**
1. Check if required fields are inputted with valid data.
2. Check if not full required fields are inputted.
3. Check if not full required fields are empty.
4. Check click on the button Save - redirect on next step.
5. Check click on the button  Back to your addresses - redirect on Address page.

**Checkout (Address)**
1. Check YOUR BILLING ADDRESS and YOUR DELIVERY ADDRESS texts
2. Check the checkbox clickable (Use the delivery address as the billing address)
3. Check the button Preceed to checkout is clickable and redirected to next step (Shipping).

**Checkout (Shipping)**
1. Check the button Preceed to checkout is clickable and redirected to next step (Payment) if checkbox is active.
2. Check if checkbox is not active is is displayed validation message.

**Checkout (Payment)**
1. Check validation message is displayed.