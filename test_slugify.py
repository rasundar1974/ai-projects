import pytest
from SlugifyApp import slugify

def test_basic_phrase():
    assert slugify("Hello World") == "hello-world"

def test_multiple_punctuation():
    assert slugify("Hello, world!!! How are you?") == "hello-world-how-are-you"

def test_emojis_removed():
    assert slugify("Python is 👍 cool!") == "python-is-cool"
