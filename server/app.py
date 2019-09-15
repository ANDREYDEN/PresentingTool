from keypress import pressKey
from flask import Flask, request
app = Flask(__name__)

@app.route('/', methods=['GET'])
def index():
    return 'Hi'

@app.route('/test', methods=['POST'])
def test():
    pressKey(request.form['key'], 1)
    return 'Bye'

if __name__ == '__main__':
    app.run(host='0.0.0.0', threaded=True, debug=True)
