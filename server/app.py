from keypress import pressKey

import socket
from flask import Flask, request
app = Flask(__name__)

@app.route('/', methods=['GET'])
def index():
    return 'Hi'

@app.route('/test', methods=['POST'])
def test():
    pressKey(request.form['key'])
    return 'Bye'

if __name__ == '__main__':
    print("Your IP: " + socket.gethostbyname(socket.gethostname()))
    app.run(host='0.0.0.0', threaded=True)
