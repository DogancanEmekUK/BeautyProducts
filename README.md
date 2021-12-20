# BeautyProducts

# Reach plc. Apps Team Exercise (Junior)

## Used Technologies

- Navigation
- LiveData
- Coroutines
- Retrofit
- MVVM
- ViewBinding
- Android Animations

## Solution

The first thing I tried to solve on this project was getting the data and showing it on
the List Fragment. I created a RecyclerView and used an Adapter to link it to the List Fragment.
I used Coroutine on the List Fragment's ViewModel in order for the application to be lighter.
Then I created a Detail Fragment and its ModelView to show the products' details. To send data 
from one fragment to the other in a more concise way, I used something I've learnt during this 
project, called "Parcelize" method. And when I was able to send the data and going to the Detail 
Fragment by using Navigation, the only thing that remained was the design. I used a CardView design
on my List Fragment's each item and used a built-in Android animation to make it slide from the left 
when first opened. Then on the Detail Fragment, I used Coordinator Layout, Appbar Layout, Collapsing 
Toolbar Layout and a Toolbar to show the image, the product name and the price in a cool way. Then 
for the description, I used a Nested Scroll View to make it all work together.
