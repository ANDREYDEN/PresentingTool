from time import sleep
from pynput.keyboard import Key, Controller

keyboard = Controller()

def pressKey(key, delay=0):
    sleep(delay)

    if key == 'left':
        keyboard.press(Key.left)
    elif key == 'right':
        keyboard.press(Key.right)


if __name__ == "__main__":
    pressKey('right', 5)
    pressKey('right', 1)
    pressKey('right', 1)
