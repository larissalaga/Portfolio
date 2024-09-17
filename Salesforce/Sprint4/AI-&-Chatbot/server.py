import os
from flask import Flask, request, jsonify, render_template
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.pipeline import Pipeline
import nltk
from nltk.corpus import stopwords
import joblib

app = Flask(__name__)

model_path = os.path.join(os.path.dirname(__file__), 'modelo_feedback.pkl')

with open(model_path, 'rb') as model_file:
    model = joblib.load(model_file)

nltk.download('stopwords')
stop_words = stopwords.words('portuguese')

@app.route('/', methods=['GET', 'POST'])
def index():
    if request.method == 'POST':
        feedback = request.form['feedback']

        text = [feedback]
        text_tfidf = model.predict(text)

        if text_tfidf[0] == 1:
            result = f'Feedback: "{feedback}" é Positivo'
        else:
            result = f'Feedback: "{feedback}" é Negativo'

        return render_template('index.html', prediction=result)

    return render_template('index.html')

if __name__ == '__main__':
    app.run(debug=True)
