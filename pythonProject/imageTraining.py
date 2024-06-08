import albumentations as A
import cv2
from matplotlib import pyplot as plt


# def visualize(image):
#     plt.figure(figsize=(10, 10))
#     plt.axis('off')
#     plt.imshow(image)


transform = A.Compose([
    A.RandomCrop(width=60, height=60),
    A.HorizontalFlip(p=0.5),
    A.RandomBrightnessContrast(p=0.2),
])
items = ["0"]

for item in items:
    image = cv2.imread(f"{item}.png")
    image = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
    for i in range(100):
        transformed_image = transform(image=image)['image']
        cv2.imwrite(f'{item}{i}.jpg', transformed_image)
