# MaryttsExt

This package is intended to be applied in the project KRISTINA. It contains an independent runtime version of the MaryTTS synthesizer for German, Turkish and Arabic languages. It manages the lip synchonization with the avatar through a stream of data control vector. 

## Input
As imput it is needed an conll document format where the sentence is detailed. Also it is needed the language to be used in the process of this sentence

## Output
These vectors are structured into a Json file that is generated everytime a sentence is processed. As result of the process there is alsso a sound file in format wave, it is generated in the same directory that the Json file.
The generated files are located at the folder MaryttsExt/src/test/resources with extensions .wav and .json

# Comments
This first version have an preliminar implementation of the phoneme to expression mapping. In near future versions this algorithm for mapping and the feature vectors itself will be improved.

version 1.0.0 - 2017, April 28.
©NLP Research Group (TALN)
Department of Information and Communication Technologies (DTIC)
Universitat Pompeu Fabra - Barcelona - Spain
