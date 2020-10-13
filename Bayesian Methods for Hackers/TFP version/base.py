
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
import tensorflow as tf
import tensorflow_probability as tfp
import warnings


tf.enable_eager_execution()
plt.style.use("fivethirtyeight")

warnings.filterwarnings("ignore")
with warnings.catch_warnings():
    warnings.filterwarnings("ignore", category=DeprecationWarning)
    warnings.filterwarnings("ignore", category=UserWarning)


tfd = tfp.distributions
tfb = tfp.bijectors



class _TFColor(object):
    """Enum of colors used in TF docs."""
    red = '#F15854'
    blue = '#5DA5DA'
    orange = '#FAA43A'
    green = '#60BD68'
    pink = '#F17CB0'
    brown = '#B2912F'
    purple = '#B276B2'
    yellow = '#DECF3F'
    gray = '#4D4D4D'

    def __getitem__(self, i):
        return [
            self.red, self.orange, self.green, self.blue, 
            self.pink, self.brown, self.purple, self.yellow, self.gray][i % 9]

TFColor = _TFColor()
