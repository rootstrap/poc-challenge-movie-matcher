import { StyleSheet } from 'react-native';

import { SCREEN_BACKGROUND } from 'theme/colors';

const styles = StyleSheet.create({
  body: {
    width: '100%',
    flexDirection: 'row',
  },
  left: {
    width: '33%',
  },
  right: {
    width: '67%',
  },
  image: {
    width: 106,
    height: 136,
    borderRadius: 8,
    backgroundColor: SCREEN_BACKGROUND,
  },
  footer: {
    alignSelf: 'center',
  },
});

export default styles;
