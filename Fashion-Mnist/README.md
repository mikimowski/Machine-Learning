# Overview

I have decided to try a few pretrained models using two/three different optimizers for each of them, subset of:<br>
{VGG16, MobileNet, ResNet50, ResNet152} x {Adagrad, sgd, adam} <br>
The intuition behind is that since our optimizers have different behaviour we might end up in different local minimas or different offsets of the same minima. Therefore ensembling those models might help us in achieving an improvement on unseen data.
<br>

Pretrained models requires image input shape of at least (32, 32, 3). <br>
Our images are of shape (28, 28, 1), therefore:

*   Image is stacked to get three channels
*   Padding is added to simulate (32, 32) images from our (28, 28) images

Intuitively this requires adjusting our already learned weights so that they know to "ignore padding".<br> Obviously weights need to adjust to the mere dataset as well.
<br>

To my surprise data augmentation led to worse results.
<br>

All trained models are available to download:
[models](https://drive.google.com/drive/folders/1KwARsMo_-h4Xgie1ok-pbxAltDBavrZD?usp=sharing) <br><br>
Note:<br>
Some additional tunning, earlier stopping, grid-search etc. could lead to further improvement in the score thus there is still a lot of space for the improvement!<br>
