import React from 'react';
import { Text, View } from 'react-native';
import { RecommendedBy } from 'types';

import Image from 'components/Image';

import styles from './styles';

interface AvatarPileProps {
  people: Array<RecommendedBy>;
}

const MAX_AVATARS = 5;

const AvatarPile = ({ people, ...props }: AvatarPileProps) => {
  const data = people.slice(0, MAX_AVATARS);
  return (
    <View {...props}>
      {!!data.length && (
        <View style={styles.container}>
          <Image source={{ uri: data[0].avatar }} style={[styles.avatar, styles.firstAvatar]} />
          {data.map(({ avatar }) => (
            <Image key={avatar} source={{ uri: avatar }} style={styles.avatar} />
          ))}
        </View>
      )}
      <Text accessibilityRole="text">
        {people.length > MAX_AVATARS ? '+20' : data.length} friends recommend this
      </Text>
    </View>
  );
};

export default AvatarPile;
