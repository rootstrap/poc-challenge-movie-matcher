import React, { useState } from 'react';
import { View } from 'react-native';

import Button from 'components/Button';

import styles from './styles';

const MovieButtons: React.FunctionComponent = () => {
  const [inList, setInList] = useState(false);
  const [recommended, setRecommended] = useState(false);

  const addToList = () => setInList(value => !value);
  const recommend = () => setRecommended(value => !value);

  return (
    <View style={styles.container}>
      <Button
        label={inList ? 'IN MY LIST' : 'ADD TO MY LIST'}
        style={styles.button}
        handleOnPress={addToList}
        isInverted
        isSelected={inList}
      />
      <Button
        label={recommended ? 'RECOMMENDED' : 'RECOMMEND'}
        style={styles.button}
        handleOnPress={recommend}
        isSelected={recommended}
      />
    </View>
  );
};

export default MovieButtons;
